//I think using toString makes it easier to read
            String Adata = stringBuilder.toString();
            String dataArray[] = Adata.split(" ");

            //include generic parameter
            List<Float> aa = new ArrayList<Float>();

            //Convert String[] into List<Float>
            for(int i=0;i<dataArray.length;i++){
                //take String i from dataArray, convert it to a float with Float.parseFloat, then add it to your list
                aa.add(Float.parseFloat(dataArray[i]));
            }

            //again, include the generic parameter
            List<Integer> a = findPeaks(aa);

            DataAlert alert = new DataAlert();
            alert.show(getFragmentManager(), "DataAlert");

            //again, using toString
            Peaks_value.setText(a.toString());
        }
    });
}

public static List<Integer> findPeaks(List<Float> points)
{
    ArrayList<Integer> peaks = new ArrayList<Integer>();
    float x1_n_ref = 0;
    int alpha = 0;

    for (int i = 0; i < points.size(); i++) {
        if (x1_n_ref - points.get(i) < 0) {
            x1_n_ref = points.get(i);
            alpha = 1;
        } else if (alpha == 1 && x1_n_ref - points.get(i) > 0) {
            peaks.add(i);
            alpha = 0;
        }
        x1_n_ref = 0;

    }


    return peaks;
}