class ClientsMapper implements SqlMapper<List<Client>>{
   @Override
   public List<Client> map(ResultSet rs){
     List<Client> result = new ArrayList<>();
     ClientMapper mapper = new ClientMapper();
     while(rs.next()){
        result.add(mapper.map(rs));
     }
     return result;
   }
}