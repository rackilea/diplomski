public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    default Optional<Categoria> findById(long codigo) {
        // return Optional.ofNullable(new Categoria(1, "name"));
        return Optional.ofNullable(null);
    }
}