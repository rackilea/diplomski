package my.package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixMultiplication {

    public List<Double> matrixVectorMulti(List<List<Double>> matrix, List<Double> vector) {
        List<Double> output = new ArrayList<>();

        for(int row = 0; row < matrix.size(); row++) {
            double sum = 0;
            for (int column = 0; column < vector.size(); column++) {
                sum += matrix.get(row).get(column) * vector.get(column);
            }
            output.add(sum);
        }
        return output;
    }

    static List<List<Double>> initializeMatrix(int matrix_size) {
        List<List<Double>> matrix = new ArrayList<>();
        int rangeMin = 100;
        int rangeMax = 200;

        for (int i=0; i<matrix_size; i++) {
            List<Double> row = new ArrayList<>();
            for (int j=0; j<matrix_size; j++) {
                row.add(rangeMin + (rangeMax-rangeMin) * new Random().nextDouble());
            }
            matrix.add(row);
        }

        return matrix;
    }

    static List<Double> initializeVector(int matrix_size) {
        List<Double> vector = new ArrayList<>();
        int rangeMin = 100;
        int rangeMax = 200;

        for (int j=0; j<matrix_size; j++) {
            vector.add(rangeMin + (rangeMax-rangeMin) * new Random().nextDouble());
        }
        return vector;
    }

    public List<Double> matrixVectorMultiParallel(List<List<Double>> matrix, List<Double> vector) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        List<Double> result = new ArrayList<>();

        //System.out.println(numOfThreads);
        //System.exit(0);
        int batchSize = matrix.size()/numOfThreads;
        PartialVectorMulti[] partialVectorMultis = new PartialVectorMulti[numOfThreads];

        int rangeStart = 0;
        int rangeEnd = 0;
        for (int i=0; i<numOfThreads; i++) {
            rangeEnd = rangeStart + batchSize-1;

            if (i == numOfThreads-1) {
                partialVectorMultis[i] = new PartialVectorMulti(matrix, rangeStart, matrix.size()-1, vector);
            } else {
                partialVectorMultis[i] = new PartialVectorMulti(matrix, rangeStart, rangeEnd, vector);
            }

            partialVectorMultis[i].start();
            rangeStart = rangeEnd + 1;
        }

        for (int i=0; i<numOfThreads; i++) {
            try {
                partialVectorMultis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i=0; i<numOfThreads; i++) {
            result.addAll(partialVectorMultis[i].getPartialResult());
        }

        return result;
    }

    public static void main(String[] args) {
        int matrix_size = 10_000;

        List<List<Double>> matrix = initializeMatrix(matrix_size);
        List<Double> vector = initializeVector(matrix_size);
        List<Double> result;
        List<Double> resultMulti;

        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();

        long startTime = System.currentTimeMillis();
        result = matrixMultiplication.matrixVectorMulti(matrix, vector);
        long endTime = System.currentTimeMillis();
        System.out.println("matrixVectorMulti: " + (endTime-startTime) + "milli seconds");

        startTime = System.currentTimeMillis();
        resultMulti = matrixMultiplication.matrixVectorMultiParallel(matrix, vector);
        endTime = System.currentTimeMillis();
        System.out.println("matrixVectorMultiParallel: " + (endTime-startTime) + "milli seconds");

    }

    class PartialVectorMulti extends Thread {
        List<List<Double>> matrix;
        List<Double> vector;
        int rowStart;
        int rowEnd;
        List<Double> partialResult = new ArrayList<>();

        public PartialVectorMulti(List<List<Double>> matrix, int rowStart, int rowEnd, List<Double> vector) {
            this.matrix = matrix;
            this.rowStart = rowStart;
            this.rowEnd = rowEnd;
            this.vector = vector;
        }

        public List<Double> getPartialResult() {
            return this.partialResult;
        }

        @Override
        public void run() {
            for (int i=rowStart; i<=rowEnd; i++) {
                double sum = 0;
                for (int j=0; j<vector.size(); j++) {
                    sum += matrix.get(i).get(j) * vector.get(j);
                }
                partialResult.add(sum);
            }
        }
    }
}