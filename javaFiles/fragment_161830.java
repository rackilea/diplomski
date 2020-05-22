@RequestMapping(value = "/pagoTarjeta.htm")
public String handleRequest(
       HttpServletRequest request, 
       HttpServletResponse response,
       @RequestParam Map<String, String> reqPar, 
       Model model) 
throws ServletException, IOException {

     String titulo = reqPar.get("titulo");
     String descripcion = reqPar.get("descripcion");
     Integer ServiceId = Integer.parseInt(reqPar.get("servicio"));
     Servicio servicioConsulta = servicioManager.getServiciobyId(ServiceId);
     ConsultaUrgente consultaUrgente = new ConsultaUrgente();
     Cliente cliente = clienteManager.getClientes().get(0);
     consultaUrgente.setDescripcion(descripcion);
     consultaUrgente.setTitulo(titulo);

     consultaUrgente.setServicioOrigen(servicioConsulta);
     consultaUrgente.setClienteOrigen(cliente);
     consultaUrgente.setEstado(EstadoConsulta.creada);

     model.addAtribute("consultaUrgente", consultaUrgente); // Add consultaUrgentre as an attribute to the model

     return "pagoTarjeta"; // Pass the model to the view
}


@PostMapping("/pagoTarjeta.htm")
protected ModelAndView onSubmit(@ModelAttribute("consultaUrgente") ConsultaUrgente consultaUrgent, ModelAndView modelAndView) throws Exception 
{
     // Retrieve the the object here.
}