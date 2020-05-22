Dim allItems As New List(Of CreatePO.item)

allItems.Add(new CreatePO.item With {.material = "Item 1 material",
                                     .plant = "Item 1 plant",
                                     .qty = 10})

purchases.item = allItems.ToArray()