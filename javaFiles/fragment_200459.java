public final class VatCode {
    private final String _code;
    public VatCode(String code)
    {
        // VAT code validation here...
        _code = code;
    }

    @Override
    public String toString() {
        return _code;
    }

    @Override
    public boolean equals(Object obj) {
        // ...
    }

    @Override
    public int hashCode() {
        // ...
    }
}

public class Person {
    private final VatCode _identifier;

    public Person(VatCode identifier)
    {
        _identifier = identifier;
    }

    // some command and some query here...
}

public class PersonDTO {
    private final String _vatCode;
    private final String _personalDescription;

    public PersonDTO(String _vatCode, String _personalDescription) {
        this._vatCode = _vatCode;
        this._personalDescription = _personalDescription;
    }
    // other fields here...

    public String getVatCode()
    {
        return _vatCode;
    }

    public String getPersonalDescription()
    {
        return _personalDescription;
    }

    // some more getter here
}

public interface LocalizedPersonalInformationService {
    PersonDTO getInformationOf(VatCode person, Locale localization) throws ProperExceptionList;
}