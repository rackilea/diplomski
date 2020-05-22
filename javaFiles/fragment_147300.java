@Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
            ArrayList<Employee> tempList = new ArrayList<Employee>();
            for(Employee emp : arrlst){
                if(emp.name.contains(s) || emp.username.contains(s))
                    tempList.add(emp);
            }
            //I am stucked here... 
            //What to do here

            arrlst = tempList;
            myadapter = new myadapter(getActivity());
            employeeList.setAdapter(myadapter); 



        }