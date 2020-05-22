@prefix : <http://other.example.org/ns#> .

   :node_1 rdf:type :Node;
    :text "Item 1";
    :iconCls 16;
    :target [
        :jQueryID "180016273543753015074";
        :number 11;
    ];
    :checked false;
    :state "open" .

  :node_2 rdf:type :Node;
    :text "Item 1";
    :iconCls 16;
    :target [
        :jQueryID "180016273543753015074";
        :number 11;
    ];
    :checked false;
    :state "open";
    rdfs:subClassOf :node_1 .