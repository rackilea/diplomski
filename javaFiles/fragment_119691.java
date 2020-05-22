TEST(StackTest, TestEmpty) {
  Stack s;
  EXPECT_TRUE(s.empty());
  s.push(1);
  EXPECT_FALSE(s.empty());
  s.pop();
  EXPECT_TRUE(s.empty());
}

TEST(StackTest, TestCount) {
  Stack s;
  EXPECT_EQ(0, s.count());
  s.push(1);
  EXPECT_EQ(1, s.count());
  s.push(2);
  EXPECT_EQ(2, s.count());
  s.pop();
  EXPECT_EQ(1, s.count());
  s.pop();
  EXPECT_EQ(0, s.count());
}

TEST(StackTest, TestOneElement) {
  Stack s;
  s.push(1);
  EXPECT_EQ(1, s.pop());
}

TEST(StackTest, TestTwoElementsAreLifo) {
  Stack s;
  s.push(1);
  s.push(2);
  EXPECT_EQ(2, s.pop());
  EXPECT_EQ(1, s.pop());
}

TEST(StackTest, TestEmptyPop) {
  Stack s;
  EXPECT_EQ(NULL, s.pop());
}


TEST(StackTest, TestEmptyOnEmptyPop) {
 Stack s;
  EXPECT_TRUE(s.empty());
  s.pop();
  EXPECT_TRUE(s.empty());
}

TEST(StackTest, TestCountOnEmptyPop) {
  Stack s;
  EXPECT_EQ(0, s.count());
  s.pop();
  EXPECT_EQ(0, s.count());
}