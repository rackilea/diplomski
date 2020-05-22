String baseHtml = "<div id='stylized' class='myform'>"
        + "<input id='txt_question' name='preg' type='text' disabled='disabled' style='width:150px;'>"
        + "<div id='detail_question'>Rock</div></div>";

Document doc = Jsoup.parse(baseHtml);
doc.getElementById("detail_question").remove();
Elements elements = doc.select("div");
System.out.println(elements);