public class PeticionServiceImpl implements PeticionService {

/*..
 */
@Inject
private EntityManager em;

@Override
public List<PeticionDTO> searchFilter( String unidad) {
    String consulta = "select peticion from Peticion peticion ";
    if (unidad != null && !"".equals(unidad)) {
        consulta = consulta + " where ";

        if (unidad != null && !"".equals(unidad)) {
            consulta = consulta
                    + " UPPER(translate(peticion.contacto.poa, 'áéíóúÁÉÍÓÚ', 'aeiouAEIOU')) LIKE UPPER(translate('%"
                    + unidad + "%', 'áéíóúÁÉÍÓÚ', 'aeiouAEIOU')) ";
            filtro = true;
        }
    }
    peticiones = peticionMapper.peticionsToPeticionDTOs((List<Peticion>) em.createQuery(consulta).getResultList());
    return peticiones;
}