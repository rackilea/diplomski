// create a mock bomb:
Bomb mockBomb = mock(Bomb.class);
// create a real detonator, but tie it to the mock bomb:
Detonator detonator = new Detonator(mockBomb);

// test the detonator. Since it's tied to a mock bomb, the block
// won't explode
detonator.pressTheRedButton();

// check it the mock bomb has been asked to explode, as it should 
// if the detonator works correctly
verify(mockBomb).explode();