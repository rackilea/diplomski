<!ELEMENT root (height+)>

<!ENTITY % objectPropAttr
 "min CDATA #REQUIRED
  max CDATA #REQUIRED">

<!ELEMENT height EMPTY>
<!ATTLIST height %objectPropAttr;>