<div id = "container" align="left">
        <%  
        String ques = null;
        String[] OpenA = {"Apa yang membawa anda ke mari?","Apa yang boleh saya bantu?", "Bagaimana saya boleh bantu anda hari ini?"};
        List<String> listO = Arrays.asList(OpenA);
        Collections.shuffle(listO);
        for (String name : listO) {
            ques = name;

        }
        out.println("Dr.Anna : "+ ques);     
        String answer=(String)request.getAttribute("answer");
            if(answer !=null)
            out.print(answer);
         %>
        </div>

        <form action='ChatServlet' method="post">
        <div id = "controls">
        <textarea name = "answer" placeholder = "Enter your messagehere...">
       </textarea>
        <button type = "submit" value="submit">Send</button>
        </div>
        </form>