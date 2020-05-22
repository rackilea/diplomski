String name = request.getParameter("name");
if (name == null || name.trim().isEmpty()) {
    messages.put("name", "Please enter name");
}

// ...

request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);