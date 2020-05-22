HttpSession session = req.getSession(true);

    for (int i = 0; i < goods.length; i++) {
        if (session.getAttribute(goods[i]) == null)
            session.setAttribute(goods[i], new Integer(0));
    }

    if ((s = req.getParameter("fifa")) != null) {
        int n = ((Integer) session.getAttribute(goods[0])).intValue();
        session.setAttribute(goods[0], new Integer(n + 1));
    } else if ((s = req.getParameter("battle")) != null) {
        int n = ((Integer) session.getAttribute(goods[1])).intValue();
        session.setAttribute(goods[1], new Integer(n + 1));
    } else if ((s = req.getParameter("gta")) != null) {
        int n = ((Integer) session.getAttribute(goods[2])).intValue();
        session.setAttribute(goods[2], new Integer(n + 1));
    }