Pattern p = Pattern.compile("\\[(.*?)]");
    String str = "EcrireNomEtudiant[public] ; EntrerMDP[private] ; AvecQui[private] ; ChoisirJour[perso] ; VerifDisponibilites[system] ; AfficherRecupilatif[private] ; EnvoyerLaDemande[system]";

    Function<String, String> finder = s -> {
        Matcher m = p.matcher(s);
        return m.find() ? m.group(1) : null;
    };
    List<String> list = Arrays.stream(str.split(";"))
        .map(finder)
        .collect(Collectors.toList());
    System.out.println(list);