public static void main(String... args) throws IOException {

        try {
            String text = "<div class=\"examplediv\"> <ul> <li><span>1</span></li> <li><span>2</span></li> <li><span>3</span></li> <li><span>4</span></li> </ul> </div> <div class=\"examplediv\"> <ul> <li><span>5</span></li> <li><span>6</span></li> <li><span>7</span></li> <li><span>8</span></li> </ul> </div> <div class=\"examplediv\"> <ul> <li><span>9</span></li> <li><span>10</span></li> <li><span>11</span></li> <li><span>12</span></li> </ul> </div> <div class=\"examplediv\"> <ul> <li><span>13</span></li> <li><span>14</span></li> <li><span>15</span></li> <li><span>16</span></li> </ul> </div>";
            String A = "", B = "", C = "", D = "";

            Document page = Jsoup.parse(text, "UTF-8");

            Elements uls = page.select(".examplediv ul");

            for(Element ul : uls) {
                Elements spans = ul.select("span");
                A += spans.get(0).text() + ",";
                B += spans.get(1).text() + ",";
                C += spans.get(2).text() + ",";
                D += spans.get(3).text() + ",";
            }

            A = A.substring(0, A.length() - 1);
            B = B.substring(0, B.length() - 1);
            C = C.substring(0, C.length() - 1);
            D = D.substring(0, D.length() - 1);

            System.out.println(A);
            System.out.println(B);
            System.out.println(C);
            System.out.println(D);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }