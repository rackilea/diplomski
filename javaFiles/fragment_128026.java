@Path("/")
@Component
@Transactional
public class ImageResource {

    @GET
    @Path("/images")
    public List<Image> getAll(){
        return this.imageDao.findAll();
    }
}