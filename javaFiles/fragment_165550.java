for (int i=0; i<products.size();i++){
            Log.d("LOG","Product size:"+products.size());
            Log.d("LOG","Product name:"+products.get(i).getName());
            Log.d("LOG","Product amt:"+products.get(i).getAmount());

            temp = new HashMap<String,String>(); //<-- add this line

            temp.put("item1", String.valueOf(i));
            temp.put("item2", products.get(i).getName());
            temp.put("item3", products.get(i).getQuantity());
            temp.put("item4", products.get(i).getType());
            temp.put("item5", products.get(i).getQuantity());
            temp.put("item6", products.get(i).getAmount());

            list.add(i, temp);
            //list.

        }