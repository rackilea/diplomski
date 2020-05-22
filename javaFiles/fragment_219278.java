package katas.countdown;

                                                                                                        import java.util.Arrays;
                                                                                                        import java.util.HashSet;
                                                                                                        import java.util.Set;

                                                                                                        enum Operator {
                                                                                                            plus("+", true), 
                                                                                                            minus("-", false), 
                                                                                                            multiply("*", true), 
                                                                                                            divide("/", false);

                                                                                                            final String sign;
                                                                                                            final boolean commutes;

                                                                                                            Operator(String sign, boolean commutes) {
                                                                                                                this.sign = sign;
                                                                                                                this.commutes = commutes;
                                                                                                            }

                                                                                                            int apply(int left, int right) {
                                                                                                                switch (this) {
                                                                                                                case plus:
                                                                                                                    return left + right;
                                                                                                                case minus:
                                                                                                                    return left - right;
                                                                                                                case multiply:
                                                                                                                    return left * right;
                                                                                                                case divide:
                                                                                                                    int mod = left % right;
                                                                                                                    if (mod == 0) {
                                                                                                                        return left / right;
                                                                                                                    } else {
                                                                                                                        throw new ArithmeticException();
                                                                                                                    }
                                                                                                                }
                                                                                                                throw new AssertionError(this);
                                                                                                            }

                                                                                                            @Override
                                                                                                            public String toString() {
                                                                                                                return sign;
                                                                                                            }
                                                                                                        }

                                                                                                        class Expression implements Comparable<Expression> {
                                                                                                            final int value;

                                                                                                            Expression(int value) {
                                                                                                                this.value = value;
                                                                                                            }

                                                                                                            @Override
                                                                                                            public int compareTo(Expression o) {
                                                                                                                return value - o.value;
                                                                                                            }

                                                                                                            @Override
                                                                                                            public int hashCode() {
                                                                                                                return value;
                                                                                                            }

                                                                                                            @Override
                                                                                                            public boolean equals(Object obj) {
                                                                                                                return value == ((Expression) obj).value;
                                                                                                            }

                                                                                                            @Override
                                                                                                            public String toString() {
                                                                                                                return Integer.toString(value);
                                                                                                            }
                                                                                                        }

                                                                                                        class OperationExpression extends Expression {
                                                                                                            final Expression left;
                                                                                                            final Operator operator;
                                                                                                            final Expression right;

                                                                                                            OperationExpression(Expression left, Operator operator, Expression right) {
                                                                                                                super(operator.apply(left.value, right.value));
                                                                                                                this.left = left;
                                                                                                                this.operator = operator;
                                                                                                                this.right = right;
                                                                                                            }

                                                                                                            @Override
                                                                                                            public String toString() {
                                                                                                                return "(" + left + " " + operator + " " + right + ")";
                                                                                                            }
                                                                                                        }

                                                                                                        class State {
                                                                                                            final Expression[] expressions;

                                                                                                            State(int... numbers) {
                                                                                                                expressions = new Expression[numbers.length];
                                                                                                                for (int i = 0; i < numbers.length; i++) {
                                                                                                                    expressions[i] = new Expression(numbers[i]);
                                                                                                                }
                                                                                                            }

                                                                                                            private State(Expression[] expressions) {
                                                                                                                this.expressions = expressions;
                                                                                                            }

                                                                                                            /**
                                                                                                             * @return a new state constructed by removing indices i and j, and adding expr instead
                                                                                                             */
                                                                                                            State replace(int i, int j, Expression expr) {
                                                                                                                Expression[] exprs = Arrays.copyOf(expressions, expressions.length - 1);
                                                                                                                if (i < exprs.length) {
                                                                                                                    exprs[i] = expr;
                                                                                                                    if (j < exprs.length) {
                                                                                                                        exprs[j] = expressions[exprs.length];
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    exprs[j] = expr;
                                                                                                                }
                                                                                                                Arrays.sort(exprs);
                                                                                                                return new State(exprs);
                                                                                                            }

                                                                                                            @Override
                                                                                                            public boolean equals(Object obj) {
                                                                                                                return Arrays.equals(expressions, ((State) obj).expressions);
                                                                                                            }

                                                                                                            public int hashCode() {
                                                                                                                return Arrays.hashCode(expressions);
                                                                                                            }
                                                                                                        }

                                                                                                        public class Solver {

                                                                                                            final int goal;

                                                                                                            Set<State> visited = new HashSet<>();

                                                                                                            public Solver(int goal) {
                                                                                                                this.goal = goal;
                                                                                                            }

                                                                                                            public void solve(State s) {
                                                                                                                if (s.expressions.length > 1 && !visited.contains(s)) {
                                                                                                                    visited.add(s);
                                                                                                                    for (int i = 0; i < s.expressions.length; i++) {
                                                                                                                        for (int j = 0; j < s.expressions.length; j++) {
                                                                                                                            if (i != j) {
                                                                                                                                Expression left = s.expressions[i];
                                                                                                                                Expression right = s.expressions[j];
                                                                                                                                for (Operator op : Operator.values()) {
                                                                                                                                    if (op.commutes && i > j) {
                                                                                                                                        // no need to evaluate the same branch twice
                                                                                                                                        continue;
                                                                                                                                    }
                                                                                                                                    try {
                                                                                                                                        Expression expr = new OperationExpression(left, op, right);
                                                                                                                                        if (expr.value == goal) {
                                                                                                                                            System.out.println(expr);
                                                                                                                                        } else {
                                                                                                                                            solve(s.replace(i, j, expr));
                                                                                                                                        }
                                                                                                                                    } catch (ArithmeticException e) {
                                                                                                                                        continue;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }

                                                                                                            public static void main(String[] args) {
                                                                                                                new Solver(812).solve(new State(75, 50, 2, 3, 8, 7));
                                                                                                            }
                                                                                                        }
                    }