if (request.getAttribute("Flavour") != null) {
        String[] flavours = (String[]) request.getAttribute("Flavour");
        for (String flavour : flavours) {
            sb.append(flavour);
            sb.append("&");
        }
        sb.trimToSize();

    }
    pageContext.setAttribute("sb", sb);