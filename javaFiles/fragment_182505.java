import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParametersApiController implements ParametersApi{

    private final CurrenciesService service;

    @Autowired
    public ParametersApiController(CurrenciesService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Currency>> GetCurrencies(@PathVariable String theCurrencyCode) {
        final List<Currency> currencies = service.getCurrencies(theCurrencyCode);
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }
}