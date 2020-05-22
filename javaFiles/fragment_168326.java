[Test]
        public void ShouldDoAnArray()
        {
            int[][] _array = new int[][] { new[] { 1, 2, 3 }, new[] { 4, 5, 6 } };
            DoSomething(_array);

        }

        public void DoSomething(int[][] array)
        {
            Assert.AreEqual(2, array.Length);
            int[] firstArray = array[0];
            Assert.AreEqual(3, firstArray.Length);
            int[] secondArray = array[1];
            Assert.AreEqual(3, secondArray.Length);
        }