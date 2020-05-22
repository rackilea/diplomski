DECLARE Name, Dose, Scheme;

// some mocked annotations
"Paracetamol" -> Name;
"40mg" -> Dose;
"daily" -> Scheme;

DECLARE Med (Name name, Dose dose, Scheme scheme);

(n:Name d:Dose s:Scheme){-> CREATE(Med, "name" = n, "dose" = d, "scheme" = s)};

DECLARE Test1, Test2, Test3;

Med.name{-> Test1}; 

m:Med ->{
    m.name{-> Test1};
    m.dose{-> Test2};
    m.scheme{-> Test3};
    };


FOREACH(med) Med{}{
    med.name{-> Test1};
    med.dose{-> Test2};
    med.scheme{-> Test3};
}