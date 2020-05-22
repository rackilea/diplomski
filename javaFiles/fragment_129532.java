public boolean larger(Student other){
        if(totMarks < other.totMarks) return false; 
        else if (totMarks > other.totMarks) return true;
        // compare names
        else return name.compareTo(other.name) > 0;
    }

    public static ArrayList<Student> sortSelection(ArrayList<Student> list){
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j< list.size(); j++){
                // comparison way changes accordingly
                if(list.get(i).larger(list.get(j))){ // swap
                    Student temp = list.get(i); 
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }