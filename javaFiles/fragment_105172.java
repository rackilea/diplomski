import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SimpleRequest {

    @NotNull
    private final String userName;

    @Min(1900)
    private final int yearOfBirth;

    @JsonCreator
    public SimpleRequest(@JsonProperty("user_name") String userName,
                         @JsonProperty("year_of_birth") int yearOfBirth) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}