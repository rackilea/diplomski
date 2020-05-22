@RequestMapping(value = "/info/cedula/{cedula}.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public InfoPersona getPersonaAsJson(@PathVariable("cedula") Integer cedula) {

        InfoPersona te = new InfoPersona();
        Persona v = Persona.findPersonaByCedulaEquals(cedula);

        if(v == null){
            return te;
        }


        setDataPersona(v.getPersonaId(), te);

        te.setTipoBusqueda("cedula");

        if(!telefonosString.equals("")){
            //eliminar la coma final
            telefonosString = telefonosString.substring(0, telefonosString.length() - 1);
            te.setAllTelefonos(telefonosString);
        }

        te.setTelefonos(numeros);

        return te;
    }