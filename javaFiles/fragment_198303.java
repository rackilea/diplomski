@PUT
@Path("{id: [A-Fa-f0-9]+}")
@Consumes(MediaType.APPLICATION_JSON)
public T update(@Context HttpServletRequest request, final T item, @PathParam("id") final String id)
{
  final Post post = getPostbyId(id);
  if (!post.allowedToUpdate(request.getUserPrincipal())
  {
    throw new UnauthorizedException();
  }
  // Authorized, carry on
}