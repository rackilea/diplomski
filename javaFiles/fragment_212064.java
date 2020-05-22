for(int i=0;i<count-1;i++)
        {

                Double lat1;
                Double lon1;
                Double lat2;
                Double lon2;
                lat1 = LatArr[i];
                lon1 = LonArr[i];

                /*System.out.println("<< BREAK >>");
                System.out.println(lat1);
                System.out.println(lon1);
                */
                lat2=latArr[i+1];
                //lat1 = null;
                lon2=lonArr[i+1];
                //lon1 = null;


                if(lat1!=null){
                GeoPoint gp1 = new GeoPoint((int)(lat1 * 1E6), (int)(lon1 * 1E6)); //
                GeoPoint gp2 = new GeoPoint((int)(lat2 * 1E6), (int)(lon2 * 1E6)); //
                System.out.println("<< LAT1 >>");
                System.out.println(lat1);
                System.out.println(lon1);
                System.out.println("<< LAT2 >>");
                System.out.println(lat2);
                System.out.println(lon2);

                Point p11 = new Point();
                Point p22 = new Point();

                Path mypath = new Path();
                projection.toPixels(gp1, p11);
                projection.toPixels(gp2, p22);
                mypath.moveTo(p22.x, p22.y);// *
                mypath.lineTo(p11.x, p11.y);// *

                canvas.drawPath(mypath, mPaint);
                }

        }