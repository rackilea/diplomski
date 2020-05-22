try {
    ps = cc.conectar.prepareStatement("UPDATE personeros SET votos = votos + 1 WHERE numero = ?");
    ps.setInt(1, candidato);
    ps.executeUpdate();
}
catch (Exception e) {
    System.out.println("Error: " + e);
}