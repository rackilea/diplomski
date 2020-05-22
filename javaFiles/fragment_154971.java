public void NomeVerificacao(List<Profissional> profissional, String nome, String categoria) {
    if (profissional.isEmpty() == true) {
        profissional.add(new Profissional(nome, categoria));
    } else {
        int i = 0;
        for (; i < profissional.size(); i++) {
            if (profissional.get(i).nome.equals(nome)) {
                System.out.println("Já Exite esse nome");
                break;
            }
        }
        if (i == profissional.size()) {
            profissional.add(new Profissional(nome, categoria));
        }
    }
}