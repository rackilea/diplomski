for (int j=0; j<serviciosSi.size();j++)
    {
            if (servAux.getId() == serviciosSi.get(j))
            {
                servAux.setAsistencia(1);
                Log.i("result","en servicio: "+servAux.getId()+" pongo asistencia: "+servAux.getAsistencia());
            }

            else
                servAux.setAsistencia(0);
    }
    listaServicios.add(servAux);