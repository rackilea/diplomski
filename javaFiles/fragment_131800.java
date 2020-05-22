package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class AlbumController {

    @Autowired
    ObjectMapper mapper;

    @RequestMapping(value = "/album", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAlbum() throws JsonProcessingException {
        Album foo = new Album("1", "foo", "John Doe", "secretProperty");

        // replace the following value with runtime logic of your choice,
        // e.g. role of a user
        boolean forInternal = false;

        ObjectWriter viewWriter;
        if (forInternal) {
            viewWriter = mapper.writerWithView(Views.Internal.class);
        } else {
            viewWriter = mapper.writerWithView(Views.Public.class);
        }

        return viewWriter.writeValueAsString(foo);
    }
}