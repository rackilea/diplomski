version: '3.4'
services:
  mg-config-server:
    image: nginx:1.10
    healthcheck:
      test: ["CMD", "bash", "-c", "sleep 15; exit 0"]
      interval: 10s
      timeout: 17s
      retries: 3
      start_period: 10s
    networks:
      - my-net
    command: bash -c "echo starting; sleep 20; nginx -g 'daemon off;'"

  mg-app-1:
    image: alpine:3.7
    healthcheck:
      test: ["CMD", "curl", "http://mg-config-server"]
      interval: 5s
      timeout: 5s
      retries: 3
      start_period: 1s
    command: sh -c 'echo starting; apk add --update curl; tail -f /dev/null'
    restart: always
    networks: 
      - my-net
    dns:
    - 8.8.8.8

networks:
  my-net:
    driver: overlay