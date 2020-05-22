.map(model -> {               // This map returns a Boletim[]
     return model.getBoletim();
 })
.map(boletim -> {             // This map returns a double[]
    Double grades = new Double[boletim.length];
    for (int i =0; i < grades.length ; i++) {
        grades[i] = boletim[i].getGrade() ;
    } 
    return grades;
}).subscribe(new Observer<Double[]>() {   // This subscribes to a double[]
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.i(TAG, "saporra vai me matar ainda");
    }

    @Override
    public void onNext(Double[] grades) {
        Log.i(TAG, Arrays.toString(grades));
    }
}