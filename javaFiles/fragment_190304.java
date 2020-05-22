pipelines:
  branches:
    '{develop,master,release/*}':
      - step:
          script:
            - echo $BITBUCKET_BRANCH