public class UsersServlet extends BaseServlet {

private UsersRepository cadastro = new UsersRepository();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    req.setAttribute("usuarios", cadastro.list());
    req.getRequestDispatcher("/usuarios/listar.jsp").forward(req, resp);

}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    User usuario = this.getUser(req);

    usuario.setNome(req.getParameter("nome"));
    usuario.setEmail(req.getParameter("email"));
    usuario.setSenha(req.getParameter("senha"));

    this.cadastro.persist(usuario);

    resp.sendRedirect(req.getContextPath() + "/usuarios");

}

protected User getUser(HttpServletRequest req) {
    User usuario;

    if (req.getParameter("id") == null) {
        usuario = new Usuario();
    } else {
        Long id = new Long(req.getParameter("id"));
        usuario = this.cadastro.search(id);
    }

    return usuario;
}

@Override
protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    User usuario = this.getUser(req);
    this.cadastro.remover(usuario);
    resp.sendRedirect(req.getContextPath() + "/usuarios");
}

@Override
protected void doForm(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

    User usuario = this.getUser(request);

    request.setAttribute("usuario", usuario);
    request.getRequestDispatcher("/usuarios/form.jsp").forward(request,
            response);
}

}