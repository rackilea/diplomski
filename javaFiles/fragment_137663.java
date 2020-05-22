List<XPathType> xpaths = new ArrayList<XPathType>();
xpaths.add(new XPathType("//r1/user", XPathType.Filter.INTERSECT));

Reference ref = fac.newReference
  ("", fac.newDigestMethod(DigestMethod.SHA1, null),
        Collections.singletonList
          (fac.newTransform(Transform.XPATH2, 
                  new XPathFilter2ParameterSpec(xpaths))),
             null, null);