String taste = jsonArray.getJSONObject(i).getString("taste");
            String rate = jsonArray.getJSONObject(i).getString("rate");

            Log.d("taste", rate);
            double rateNum = Double.parseInt(rate);

            Log.d("taste", "rateNum is " + rateNum);

            double percent = rateNum / count;

            percent = percent * 100;

            Log.d("taste", "percent is " + percent);