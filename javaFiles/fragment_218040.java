import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


     @Query(value = "SELECT  new com.dto.UserDto(u) FROM com.entity.UserEntity AS u",
       countQuery = "SELECT count(u) FROM com.entity.UserEntity AS u")
      public Page<UserDto> getUsers(Pageable page);