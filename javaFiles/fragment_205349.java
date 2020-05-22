new MockUp<MoveItemActivity>()
    {
        @Mock
        IsItemStowable isItemStowable(MoveItemRequest request) {
            return new IsItemStowable();
        }
    };