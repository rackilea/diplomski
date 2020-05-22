@Override
public void validate() {
    boolean error = false;

    Collection<?> tmp = getActionErrors();

    for (Object o : tmp) {
        if (o.toString().contains(
                "the request was rejected because its size")) {

            if (!error) {
                addFieldError("foto",
                        "El tamaño de la foto es muy grande (Máximo: 2MB)");
                error = true;
            }
        }
    }

}