broadcast(set1RowDataset)
        .join(set2RowDataset, "id")
        .join(set3RowDataset, "id")
        .join(set4RowDataset, "id")
        .join(set19RowDataset, "id")
        .as(Encoders.bean(Set.class));