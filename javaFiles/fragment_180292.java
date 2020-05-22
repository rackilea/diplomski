if(model.options.target.isLaterThan(SpecVersion.V2_1)) {
        // @XmlSeeAlso
        Iterator<CClassInfo> subclasses = cc.target.listSubclasses();
        if(subclasses.hasNext()) {
            XmlSeeAlsoWriter saw = cc.implClass.annotate2(XmlSeeAlsoWriter.class);
            while (subclasses.hasNext()) {
                CClassInfo s = subclasses.next();
                saw.value(getClazz(s).implRef);
            }
        }
    }