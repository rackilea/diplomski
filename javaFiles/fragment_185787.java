String[] input = JOptionPane.showInputDialog("What are your grades of this month?").split(" ");
        double[] grades = new double[input.length];
        double average = 0.0;
        for (int i = 0; i < input.length; i++) {
            // Note that this is assuming valid input
            grades[i] = Double.parseDouble(input[i]);
            average+=grades[i];
        }
        average /= grades.length;