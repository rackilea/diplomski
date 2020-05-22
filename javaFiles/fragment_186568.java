StringBuilder result = new StringBuilder();
            if(count>0) // check if count is greater than o
                            // count can be 0 if you don't select any check box
            {
            for(int i=0;i<count;i++)

            {Log.i("checked content Inside on click of share ",""+aa.get(i));
                if(mCheckStates.get(i)==true)
                {
                     result.append("Title:");
                     result.append(bb.get(i));

                     result.append("\n");
                     result.append("Content:");
                     result.append(aa.get(i));
                     result.append("\n");

                }

            }
            }