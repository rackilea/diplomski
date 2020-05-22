import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;

import graphql.ExecutionResult;
import graphql.servlet.core.GraphQLQueryInvoker;
import graphql.servlet.core.internal.GraphQLRequest;
import graphql.servlet.input.GraphQLInvocationInputFactory;
import graphql.servlet.input.GraphQLSingleInvocationInput;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping(path = "api")
public class CompanyController {

    @Autowired
    private GraphQLInvocationInputFactory invocationInputFactory;

    @Autowired
    private GraphQLQueryInvoker queryInvoker;

    @GetMapping("company/{id}")
    public ResponseEntity<?> societe(@PathVariable @NotNull Integer id) {
        String query = "query ($id: Int!) { company(id: $id) { id name andsoon } }";
        /*
         * ImmutableMap is a Guava class; you can build the map (e.g. a HashMap) on your
         * own, or simply Map.to(..) in Java 9, or even @PathVariable Map<String,
         * Object> variables as the method's parameter instead (but you'll miss the
         * validation).
         */
        Map<String, Object> variables = ImmutableMap.of("id", id);

        GraphQLRequest request = new GraphQLRequest(query, variables, null);
        GraphQLSingleInvocationInput invocationInput = invocationInputFactory.create(request);
        ExecutionResult result = queryInvoker.query(invocationInput);

        /*
         * Of course result.getData() can be null here - see also result.isDataPresent()
         * - but data/error handling's left to you
         */
        Optional<Object> company = Optional.ofNullable(result.getData().get("company"));
        return ResponseEntity.of(company);
    }

}