for(Future<Resp> future : futureList) {
        try {
            Assertions.assertThat(futureResponse.get()).isEqualTo(RespObj);
        } catch (Throwable e) {
            Assertions.assertThat(e).isInstanceOf(ExecutionException.class);
        }
    }