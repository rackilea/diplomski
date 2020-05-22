public static void main(String... args) throws IOException {

    try {
        String text = "<div class=\"examplediv\"> <ul> <li><span>1</span></li> <li><span>2</span></li> <li><span>3</span></li> <li><span>4</span></li> </ul> </div> <div class=\"examplediv\"> <ul> <li><span>5</span></li> <li><span>6</span></li> <li><span>7</span></li> <li><span>8</span></li> </ul> </div> <div class=\"examplediv\"> <ul> <li><span>9</span></li> <li><span>10</span></li> <li><span>11</span></li> <li><span>12</span></li> </ul> </div> <div class=\"examplediv\"> <ul> <li><span>13</span></li> <li><span>14</span></li> <li><span>15</span></li> <li><span>16</span></li> </ul> </div>";
        ArrayList<String> A = new ArrayList<String>(), B = new ArrayList<String>(), C = new ArrayList<String>(), D = new ArrayList<String>();

        Document page = Jsoup.parse(text, "UTF-8");

        Elements uls = page.select(".examplediv ul");

        for(Element ul : uls) {
            Elements lis = ul.select("span");
            A.add(lis.get(0).text());
            B.add(lis.get(1).text());
            C.add(lis.get(2).text());
            D.add(lis.get(3).text());
        }

        for(String str : A) {
            System.out.print(str + " ");
        } System.out.println("");

        for(String str : B) {
            System.out.print(str + " ");
        } System.out.println("");

        for(String str : C) {
            System.out.print(str + " ");
        } System.out.println("");

        for(String str : D) {
            System.out.print(str + " ");
        } System.out.println("");
    } catch(Exception e) {
        e.printStackTrace();
    }
    }