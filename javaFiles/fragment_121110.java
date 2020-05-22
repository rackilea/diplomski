<%
    java.io.File[] files = life_ray.OpenDir.listSamplePictures();
    for (int i = 0; i < files.length; i++) {
        out.println("<img src=\"" + files[i].getAbsolutePath() + "\" alt=\"\">");
    }
%>