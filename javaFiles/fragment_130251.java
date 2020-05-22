for (int ii = 0; ii<1; ii++){ // here is the only change. add ii instead of i
            JSONObject obj2 = arr2.getJSONObject(ii); // here also replace your i with ii
            Faktor faktor = new Faktor();
            faktor.setId(obj2.getString("Id"));
            faktor.setTaeed(obj2.getString("taeed"));
            faktor.setCodkala(obj2.getString("codkala"));
            faktor.setNamekala(obj2.getString("namekala"));
            faktor.setCount(obj2.getString("count"));
            faktor.setChid(obj2.getString("chid"));
            faktorlist.add(faktor);
        }