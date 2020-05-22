abstract class AbstractDtoXmlParser<T extends Dto> {
    public abstract T getDto();
}

class WhateverDtoXmlParser extends AbstractDtoXmlParser<WhateverDto> {

    @Override
    public WhateverDto getDto() {
        return new WhateverDto();
    }
}