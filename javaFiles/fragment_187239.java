// for(int k=i+1;k<students.length-1;k++){
        for(int k=i+1;k<students.length;k++){
            Student temp2= students[k];
            int result = temp2.compareTo(temp);
            if(result > 0){
                students[k] = temp;
                students[i] = temp2;
            }
        }
    }
}